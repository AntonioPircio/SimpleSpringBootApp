FROM postgres
ENV POSTGRES_PASSWORD password
ENV POSTGRES_USER user
ENV POSTGRES_DB test
EXPOSE 5432