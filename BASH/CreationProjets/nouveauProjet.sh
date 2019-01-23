#!/bin/bash
$projet
$bootstrap

function creationDossier

{
	echo "Quel est le nom du nouveau projet ?"
	read projet
	#Creation du dossier du projet dans /var/www/html/
	mkdir /var/www/html/$projet
}
echo "Projet Bootstrap ? o ou n"
read bootstrap

if [ $bootstrap = "o" ]
then
	creationDossier
	cp -R /var/www/html/scriptsBach/nouveauProjet/bootstrap/* /var/www/html/$projet
	echo "Projet creer"
elif [ $bootstrap = "n" ]
then
	creationDossier
	cp -R /var/www/html/scriptsBach/nouveauProjet/site/* /var/www/html/$projet
	echo "Projet creer"
else
	echo "Pas de nouveau projet"
fi
