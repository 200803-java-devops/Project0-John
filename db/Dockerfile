FROM postgres
ENV POSTGRES_USER john
ENV POSTGRES_PASSWORD root
ENV POSTGRES_DB projectdb
ADD *.sql /docker-entrypoint-initdb.d 
EXPOSE 5432
