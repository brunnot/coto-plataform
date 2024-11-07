#!/bin/bash

ENV=${1:-none}

if [ "$ENV" = "help" ]
then
	echo "Opções: "
	echo "local = Compila e instala as imagens e pacotes na máquina local."
	echo "prod = Compila e instala as imagens e pacotes no reposítório de imagem para produção."
	exit 1
fi

while [[ ${ENV} != "local" ]] && [[ ${ENV} != "prod" ]]
do
  read -p "Choose the environment (local, prod): " t_env
  ENV=${t_env:-none}
done

if [ "$ENV" = "prod" ]
then
  mvn clean install package -P${ENV} -Dmaven.test.skip=true
else
  mvn clean install package -P${ENV} -Dmaven.test.skip=true
fi
