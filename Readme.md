Start Opensearch docker container without SSL for POC, enable SSL in prod 
docker run -it -p 9200:9200 -p 9600:9600 -e OPENSEARCH_INITIAL_ADMIN_PASSWORD=Elastic123@1a -e "discovery.type=single-node" -e "plugins.security.ssl.http.enabled=false"  --name opensearch-node opensearchproject/opensearch:latest
