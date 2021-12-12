# API Documentation
## create user
- http method: POST
- url: http://{domain}/api/v1/users
- request body		
    ```json
    {
      "name": "Jack",
      "address":  "Shanghai",
      "description":  "this is description",
      "dateOfBirth":  "1993-03-09"
    }
    ```

  parameters				    |type		|required   |sample
      :----						|:---		|:------    |:------	
  name						|string		|Required	|Jack
  address					    |string		|Optional	|Shanghai
  description				    |string		|Optional	|this is description
  dateOfBirth				    |date		|Optional   |1993-03-09

- response body		
    ```json
    {
      "data": {
        "id": 1
      }
    }
    ```
  parameters				    |type	        |sample
        :----						|:---	        |:------
  id                          |Long           |1

## update user
- http method: PUT
- url: http://{domain}/api/v1/users/{id}
- request params

  parameters				    |type		|required   |sample
  :----						    |:---		|:------    |:------	
  name						    |string		|Optional	|Jack
  address					    |string		|Optional	|Shanghai
  description				    |string		|Optional	|this is description
  dateOfBirth				    |date		|Optional   |1993-03-09

- request body
    ```json
    {
      "data": {
        "name": "Jack",
          "address":  "Shanghai",
          "description":  "this is description",
          "dateOfBirth":  "1993-03-09"
      }
    }
    ```
  
- no response body

## delete user
- http method: DELETE
- url: http://{domain}/api/v1/users/{id}
- no response body

## query user
- http method: GET
- url: http://{domain}/api/v1/users/{id}
- response body
    ```json
    {
      "data": {
        "id": 1,
        "name": "Token Jan",
        "dateOfBirth": "1993-06-05",
        "address": "Shangahi",
        "description": "this is description",
        "createdAt": "2021-12-12T09:22:26"
      }
    }
    ```

    parameters				    |type	        |sample
      :----						|:---	        |:------
    id                          |Long           |1
    name						|string	    	|Jack
    address					    |string	    	|Shanghai
    description				    |string	        |this is description
    dateOfBirth				    |date	        |1993-03-09
    createdAt				    |datetime	    |2021-12-12T09:22:26
    

## response code explaination
response code	|description
:----	|:---
200		|successful
404		|entity not found
