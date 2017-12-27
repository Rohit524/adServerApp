# adServerApp
adServer
Deployment Instruction

1. Deploy the application in the apache server
2. Go to the url for creating new ads: /adServer/homePage
3. To get all the ads: /adServer/ad/getAllAds
4. To get a ad based on partner id : /adServer/ad/{partner_id}

Application consists Of
1. Creating new ads
2. Getting ads based on partner id
3. Getting all the ads(Bonus Question)
4. Getting and Storing multiple ads for partner id(Bonus)
5. JUnits
6. Error Handling

Advantages & Disadvantages of Persistance mechanism(Bonus) 
Advantages: 
1. All the ads are stored as key value pairs, where the key is the partner id and value is list of ads
2. Easy to retrive, add new ads and add ads to existing partner id 
Disadvantages: 
1. Not thread safe 
2. Once the application is restared all the data is deleted
