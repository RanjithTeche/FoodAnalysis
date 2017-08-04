# FoodAnalysis Service

FoodAnalysis Service provide the maximum  food satisfaction for give time.

# Assignment
Gordon Ramsey, a very smart guy, likes eating food. Now, Gordon is at a restaurant and he has many different types of food to choose from. Gordon gets x amount of satisfaction and requires y amount of time to eat an item from the menu. Given t minutes, write a java program that reads the text file and ﬁnds out the maximum satisfaction that Gordon can get from eating at the restaurant. You will be given a text file with the following format:

### Note

- [t][Number of items on menu]
- [amount of satisfaction from eating dish 1][time taken for dish 1]
- [amount of satisfaction from dish 2][time taken for dish 2]


### Solution:
The application uses KnapSack Algorithm to find the Maximum Satisfaction. The value is `2493893` . Unit Testing includes Java (JUnit) testcase. 

### How to Use:
- Clone/Download the project go to the workspace use the following command
  ### gradle clean build bootRun >  log.txt
- Open the brwoser [http://localhost:8080/](http://localhost:8080/) use the link it will provide screen to upload the food statics data.
- After select data click on the [Analyse](http://localhost:8080/api/v1/upload/foodStatistics) buttoon, It will return the max satisfaction if the input valid  else it will show the error message.

  

