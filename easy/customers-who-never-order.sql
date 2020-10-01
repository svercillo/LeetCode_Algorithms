# Write your MySQL query statement below

Select Name as Customers from customers
left join orders on customers.Id = customerid
where customerid is null
