FROM postgres
ENV POSTGRES_USER john
ENV POSTGRES_PASSWORD root
ADD *.sql /docker-entrypoint-initdb.d 
EXPOSE 5432
