echo  *** Exportar e Importar Base de Datos MySQL ***
echo basado en https://gist.github.com/kamikaze-lab/98e901d961db59fd0db8

echo ----------------- EXPORTAR COMPLETAMENTE LA BDD ------------------------------
echo ubicarme en la ruta 'fuzzysystem/'
echo Ejecutar la siguiente linea he ingresar el password de la BDD

mysqldump -h localhost -u root -p dephifuzzymethod > BDD/bdd_fuzzysystem_full.sql

echo ----------------- EXPORTAR EXTRUCTURA SIN DATOS ------------------------------
echo Exportar solo la estructura de la base de datos, sin la información que pudiera contener.

mysqldump -h localhost -u root -p --no-data=TRUE dephifuzzymethod > BDD/bdd_fuzzysystem_structure.sql

echo ----------------- EXPORTAR DATOS sin ESTRUCTURA -------------------------------
echo Esta variación exporta solo la información de nuestra base de datos, excluyendo la estructura de la misma.

mysqldump -h localhost -u root -p --no-create-info=TRUE dephifuzzymethod > BDD/bdd_fuzzysystem_data.sql
echo ===============================================================================


echo ===== IMPORTAR si la BDD ya existe -------
mysql -u root -p dephifuzzymethod < BDD/bdd_fuzzysystem_full.sql

