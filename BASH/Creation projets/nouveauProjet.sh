#!/bin/bash
#v2.0.0
#
#nouveauProjet.sh et le dossier nouveauProjet a mettre a la racine de son serveur de dev uniquement
#
#

$projet
$bootstrap
$typeProjet

function droitDossier
{
	chmod -R 777 $projet
}

function creationDossier
{
	echo "Quel est le nom du nouveau projet ?"
	read projet
	#Creation du dossier du projet dans /var/www/html/
	mkdir $projet
	droitDossier
}
function angular
{
	echo "Quel est le nom du nouveau projet ?"
	read projet
	ng new $projet
	chmod -R 777 $projet
	cd $projet
	ng serve -o
}
function bootstrap
{
	creationDossier
	cp -R nouveauProjet/bootstrap/* $projet
	echo "Projet creer"
}
function web
{
	creationDossier
	cp -R nouveauProjet/site/* $projet
	echo "Projet creer"
}

echo "Quel Type de projet voulez vouz faire ? Angular(a), Bootstrap(b), Web Simple(w) ?"
read typeProjet

case $typeProjet in
		[aA]*)
			angular;;
		[bB]*)
			bootstrap;;
		[wW]*)
			web;;
		*)
			echo "Je connais pas ce type";;
esac
