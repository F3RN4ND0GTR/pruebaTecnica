# pruebaTecnica

En este proyecto he abogado por utilizar la query HQL (Sql en Hibernate) para realizar la búsqueda y filtrarla por los datos. Dicha query está de esta manera:

select p from Prices p where p.productId = :identificador and p.brandId = :cadena and p.startDate < :fecha and p.endDate > :fecha order by p.priority desc

Esto es equivalente a la query en SQL:

select * from Prices where product_id = <identificador> and brand_id = <cadena> and start_date < <fecha_dada> and end_date > <fecha_dada> order by priority desc
