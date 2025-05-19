-- Write your MySQL query statement below
-- we are basically writing an unpivot function where we convert columns --> rows. need to use union all. start by selecting product id and creating the given store for all 3 ossible values
SELECT product_id, 'store1' AS store, store1 AS price
FROM Products
WHERE store1 IS NOT NULL

UNION ALL

SELECT product_id, 'store2', store2
FROM Products
WHERE store2 IS NOT NULL

UNION ALL

SELECT product_id, 'store3', store3
FROM Products
WHERE store3 IS NOT NULL

GROUP BY product_id