#!/bin/bash

# Configurações do banco de dados principal (Oracle)
PRIMARY_HOST="oracle.fiap.com.br"
PRIMARY_USER="user"
PRIMARY_PASSWORD="pass"
PRIMARY_DB="orcl"

# Configurações do banco de dados replicado (MySQL)
REPLICA_HOST="legado-replica.com"
REPLICA_USER="user"
REPLICA_PASSWORD="pass"
REPLICA_DB="db"

# Data e hora atual para o backup
DATE=$(date +"%Y%m%d%H%M%S")
BACKUP_FILE="/tmp/db_backup_${DATE}.dmp"

# Cria um backup do banco de dados principal
echo "Criando backup do banco de dados Oracle..."
expdp $PRIMARY_USER/$PRIMARY_PASSWORD@//$PRIMARY_HOST/$PRIMARY_DB DIRECTORY=backup_dir DUMPFILE=$BACKUP_FILE LOGFILE=backup.log

if [ $? -ne 0 ]; then
  echo "Erro ao criar backup do banco de dados Oracle."
  exit 1
fi

# Restaura o backup no banco de dados replicado (MySQL)
echo "Restaurando backup no banco de dados replicado..."
mysql -h "$REPLICA_HOST" -u "$REPLICA_USER" -p"$REPLICA_PASSWORD" "$REPLICA_DB" < "$BACKUP_FILE"

if [ $? -ne 0 ]; then
  echo "Erro ao restaurar backup no banco de dados replicado."
  exit 1
fi

# Remove o arquivo de backup temporário
rm "$BACKUP_FILE"

echo "Replicação concluída com sucesso."
