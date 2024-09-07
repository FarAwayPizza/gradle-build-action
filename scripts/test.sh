#!/bin/bash

echo "Creating User 1..."
curl -X POST http://localhost:8080/users \
-H "Content-Type: application/json" \
-d '{
  "username": "user1",
  "email": "user1@example.com"
}'

echo "Listing all users..."
curl -X GET http://localhost:8080/users \
-H "Content-Type: application/json"

echo "Creating User 2..."
curl -X POST http://localhost:8080/users \
-H "Content-Type: application/json" \
-d '{
  "username": "user2",
  "email": "user2@example.com"
}'

echo "Listing all users again..."
curl -X GET http://localhost:8080/users \
-H "Content-Type: application/json"

echo "User 1 creating a poll..."
curl -X POST http://localhost:8080/polls \
-H "Content-Type: application/json" \
-d '{
  "question": "What is your favorite color?",
  "publishedAt": "2024-09-04T10:30:00Z",
  "validUntil": "2024-09-10T10:30:00Z",
  "options": [
    { "caption": "Red", "presentationOrder": 1 },
    { "caption": "Blue", "presentationOrder": 2 }
  ]
}'

echo "Listing all polls..."
curl -X GET http://localhost:8080/polls \
-H "Content-Type: application/json"

echo "User 2 voting on the poll..."
curl -X POST http://localhost:8080/votes \
-H "Content-Type: application/json" \
-d '{
  "username": "user2",
  "pollId": 1,
  "option": "Blue",
  "publishedAt": "2024-09-04T11:00:00Z"
}'

echo "User 2 changing the vote..."
curl -X PUT http://localhost:8080/votes \
-H "Content-Type: application/json" \
-d '{
  "username": "user2",
  "pollId": 1,
  "option": "Red",
  "publishedAt": "2024-09-04T11:15:00Z"
}'

echo "Listing all votes..."
curl -X GET http://localhost:8080/votes \
-H "Content-Type: application/json"

echo "User 1 deleting the poll..."
curl -X DELETE http://localhost:8080/polls/1 \
-H "Content-Type: application/json"

echo "Listing all votes after poll deletion..."
curl -X GET http://localhost:8080/votes \
-H "Content-Type: application/json"
