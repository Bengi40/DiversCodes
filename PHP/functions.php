<?php
// nettoye les inputs des espaces, caractères spéciaux...
function checkInput($data) 
{
	$data = trim($data);
	$data = stripslashes($data);
	$data = htmlspecialchars($data);
	return $data;
}

// Trasnforme une date au format Us en format FR
function dateFr($dateAmericaine){
	$date = explode("-",$dateAmericaine);
	$nouvelleDate = $date[2].'/'.$date[1].'/'.$date[0];
	return $nouvelleDate;
}

?>
