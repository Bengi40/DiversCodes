



// Dépendance Maven à rajouter
//
// <dependency>
//     <groupId>commons-beanutils</groupId>
//     <artifactId>commons-beanutils</artifactId>
//     <version>1.9.4</version>
// </dependency>

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.ResultSetDynaClass;

/**
 * 
 * @author phil
 *
 * @param <T> : le paramètre T désigne un java bean du modèle.
 */
public class Mapper<T> {
	
	private String className;
	
	public Mapper(String className) {
		super();
		this.className = className;
	}

	/**
	 * 
	 * @return la liste des entités 
	 */
	public List<T> getAll(ResultSet resultSet) {

		List<T> liste = new ArrayList<T>();
		// Boucle while sur toutes les lignes du resultset
		try {
			// On transforme le ResutlSet en ResultSetDynaClass
			// pour avoir certaines méthodes/propriétés.
			ResultSetDynaClass resultSetDynaClass = new  ResultSetDynaClass(resultSet);
			// on récupère l'itérateur du ResultSetDynaClass
			Iterator<DynaBean> iterator = resultSetDynaClass.iterator();
			// On boucle sur l'itérateur
			while(iterator.hasNext()) {
			
				// on récupère la ligne du ResultSetDynaClass
				DynaBean row = (DynaBean) iterator.next();
				// Créer la classe du java bean à partir de son nom
				Class<?> beanClass = Class.forName(className);
				// Instancier l'objet
				Object instance = beanClass.newInstance();
				// Remplir les propriétés de l'instance à partir des données du ResultSet
				BeanUtils.copyProperties(instance,row);
				// Changer le type de instance
				T t = (T) instance;
				liste.add(t);
			}
				
		} catch (SQLException | IllegalAccessException | InvocationTargetException  | ClassNotFoundException | InstantiationException   e) {

			e.printStackTrace();
		}
		return liste;
	}
	
	public T getOne(ResultSet resultSet) {
		List<T> liste = getAll(resultSet);
		if (liste == null || liste.size() == 0)
			return null;
		else			
		    return liste.get(0);
	}

}