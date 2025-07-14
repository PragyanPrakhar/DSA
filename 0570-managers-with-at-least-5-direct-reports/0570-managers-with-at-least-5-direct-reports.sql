SELECT e.name
FROM Employee e
JOIN Employee d ON e.id = d.managerId
GROUP BY e.id
HAVING COUNT(*) >= 5;
