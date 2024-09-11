#!/bin/bash

# Configurações do banco de dados principal (Oracle)
PRIMARY_HOST="oracle.fiap.com.br"
PRIMARY_USER="rm87323"
PRIMARY_PASSWORD="141003"
PRIMARY_DB="orcl"

# Configurações do banco de dados replicado (MySQL)
REPLICA_HOST="legado-replica.com"
REPLICA_USER="user"
REPLICA_PASSWORD="pass"
REPLICA_DB="db"

# Data e hora atual para o backup
DATE=$(date +"%Y%m%d%H%M%S")
BACKUP_FILE="/tmp/db_backup_${DATE}.csv"

# Cria um backup do banco de dados principal (exporta para CSV)
echo "Criando backup do banco de dados Oracle em formato CSV..."
sqlplus -s $PRIMARY_USER/$PRIMARY_PASSWORD@//$PRIMARY_HOST/$PRIMARY_DB <<EOF
SET MARKUP CSV ON
SPOOL $BACKUP_FILE
SELECT * FROM sua_tabela; -- Substitua pela(s) tabela(s) necessárias
SPOOL OFF
EXIT;
EOF

if [ $? -ne 0 ]; then
  echo "Erro ao criar backup do banco de dados Oracle."
  exit 1
fi

# Restaura o backup no banco de dados replicado (MySQL)
echo "Restaurando backup no banco de dados replicado..."
mysql -h "$REPLICA_HOST" -u "$REPLICA_USER" -p"$REPLICA_PASSWORD" "$REPLICA_DB" <<EOF
LOAD DATA LOCAL INFILE '$BACKUP_FILE'
INTO TABLE sua_tabela -- Substitua pela tabela apropriada
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n';
EOF

if [ $? -ne 0 ]; then
  echo "Erro ao restaurar backup no banco de dados replicado."
  exit 1
fi

# Remove o arquivo de backup temporário
rm "$BACKUP_FILE"

echo "Replicação concluída com sucesso."
