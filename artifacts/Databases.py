
# Create Function

import json
from bson import json_util
from pymongo import MongoClient

connection = MongoClient('localhost', 27017)
db = connection["market"]
collection = db["stocks"]

def create_document(document):
  try:
    result=collection.save(document)
  except ValidationError as ve:
    abort(400, str(ve))
    return result
  
  # create company named "Computer Science"
def main():
  myDocument = {
    "Company" : "Computer Science"
  }
  
  print create_document(myDocument)
  
main()

# Update Function

import json
from bson import json_util
from pymongo import MongoClient

connection = MongoClient('localhost', 27017)
db = connection["market"]
collection = db["stocks"]

def update_document(document):
  try:
    result=collection.save(document)
  except ValidationError as ve:
    abort(400, str(ve))
    return result
 # Update new Company named Computer Science set new, number, length, Grade average and status
def main():
  myDocument = {
    {"Company" : "Computer Science"},
    {"$set" : {"Number" : 499}},
    {"$set" : {"length" : 8}},
    {"$set" : {"Grade average" : 80}},
    {"$set" : {"Status" : "active"}}
  }
  
  print update_document(myDocument)
  
main()

# Delete function to remove all classes not active

import json
from bson import json_util
from pymongo import MongoClient

connection = MongoClient('localhost', 27017)
db = connection["market"]
collection = db["stocks"]

def remove_document(document):
  try:
    result=collection.remove(document)
  except ValidationError as ve:
    abort(400, str(ve))
    return result
 # remove all companies that are not active
def main():
  myDocument = {
    "Status" : "not active"}
  }
  
  print remove_document(myDocument)
  
main()

#Document Retrieval
import json
from bson import json_util
from pymongo import MongoClient

connection = MongoClient('localhost', 27017)
db = connection["market"]
collection = db["stocks"]


# method to return grade averages
def find_document(document):
  try:
    result=collection.find(document)
  except ValidationError as ve:
    abort(400, str(ve))
    return result
def main():
  num_val_1 = input("first numerical value: \n")
  num_val_2 = input("second numerical value: \n")
  if num_val_2 > num_val_1:
    my_peram_doc = {
      "$gte" : num_val_1, "$lte" : num_val_2
    }
    myDocument = {
      "Grade average" : my_peram_doc
    }

    print find_document(myDocument)
    
  else:
    my_peram_doc = {
      "$gte" : num_val_2, "$lte" : num_val_1
    }
    myDocument = {
      "Grade average" : my_peram_doc
    }
 
    print find_document(myDocument)
  
main()

# Document Retrieval 
import json
from bson import json_util
from pymongo import MongoClient

connection = MongoClient('localhost', 27017)
db = connection["market"]
collection = db["stocks"]


# retreives classes that are active and displays
def find_document(document):
  try:
    result=collection.find(document)
  except ValidationError as ve:
    abort(400, str(ve))
    return result
def main():
  user_string = input("Select Classes: \n")
  
  my_peram_doc = {
      user_string
    }
  myDocument = {
      "Company" : my_peram_doc, {"Status" : "active"}
    }
  print find_document(myDocument)
  
main()


