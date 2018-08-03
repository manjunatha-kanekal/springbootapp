# springbootapp

# aws base url: http://springbootapp.us-east-2.elasticbeanstalk.com
# Resources
1.  Retrieve all employees
	Type: Get
    URL: `/employees/all`

2. `Inserting new employee record`
    Type: Put
    URL: `/employees`
    ```json
    {
        "id": "5b602ba92138ad36600087f2",
        "first_name": "firstname",
        "last_name": "lastname",
        "department": "Product Development",
        "dob": "1991-02-24T00:00:00.000+0000",
        "designation": "SSE",
        "doj": "2016-05-26T00:00:00.000+0000",
        "doe": null,
        "address": {
            "house_no": "1",
            "address_line2": "Sample",
            "street": "Sample Street",
            "city": "city",
            "pincode": "123456"
        },
        "skillsets": [
            {
                "skill": "Core Java",
                "rating": 8,
                "endorsed": true
            },
            {
                "skill": "Python",
                "rating": 5,
                "endorsed": false
            },
            {
                "skill": "MongoDB",
                "rating": 6,
                "endorsed": false
            },
            {
                "skill": "Salesforce",
                "rating": 8,
                "endorsed": true
            }
        ]
    }
    ```

3. `UPSERT a record`
    Type: Post
    URL: `/employees`
    ```json
    {
        "id": "5b602ba92138ad36600087f2",
        "first_name": "firstname",
        "last_name": "somelastname",
    }
    ```


4. `Delete a record`
    Type: Delete
    URL: `/employees/{id}`


5. `Find`
    Type: Get
    URL: `/employees/{id}`


6.  `Find by department`
    Type: Get
    URL: `/employees/department/{department}`


7.  `Find by designation`
    Type: Get
    URL: `/employees/designation/{designation}`


8.  `Find by city`
    Type: Get
    URL: `/employees/city/{city}`


9.  `Find by skill with minimum rating`
    Type: Get
    URL: `/employees/skill/{skill}/minrating/{minrating}`