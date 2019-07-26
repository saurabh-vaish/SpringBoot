package com.app.config;

public class HazelCastCacheInfo {

	
	/***
	 *  Cache : It is a temporary memory used at application side to reduce network calls between Application and Database 
	 *  		For Commonly Accessed Code . 
	 *  		Cache is used to save time for network calls , that increases app performance .
	 *  
	 *  HazelCast Cache : In spring boot cache management is implemented by HazelCast . Spring boot gives cache abstraction 
	 *  					they provide solution for it.
	 *  
	 *  	***  Config (C) :-  For creating cache memory for application we neet to configure this class .
	 *  						It creates Cache instance .
	 *  
	 *  	*** MapConfig(C)  :--  To enable cache for one module we use MapConfig object and provide details like name ,size ,life time,Eviction
	 * 								It stores data in key, value format
	 * 
	 * 					One Module == One MapConfig
	 * 
	 * 
	 *		Eviction Policy ---> It is an enum designed with eviction Possilble values like - LRU, LFU ,RANDOM, NONE
	 *							It means removing an object from cache based on conditions  
	 * 
	 * 
	 * 		For implementing cache --->  
	 * 
	 * 							1. selection cache for starter  (starter-cache)
	 * 							2. Need hazelcast , hazelcast-spring dependecies from maven repo
	 * 							
	 * 							3. Make a configuration class 
	 * 							   Configure Config class  (@Bean)  -- > set instance Name , add MapConfig 
	 * 							
	 * 							4. Write @EnableCaching  on start class to enable caching
	 * 
	 * 							5. Implement serializable on the  model class which need caching
	 * 
	 * 							6. use @Cachable for select methods, @CacheEvict for delete method in service class
	 * 
	 * 							7. Use @CachePut on update method , it will update chache first then db
	 * 						@Cachable( value=" MapConfig object name" , key = "PK Variable Name")
	 * 						public Customer getCustomerById(Integer custId){}
	 * 
	 * 						@CacheEvict( value=" MapConfig object name" , key = "PK Variable Name")
	 * 						public void deleteCustomerById(Integer custId){}
	 * 
	 * 						@Cacheput(value="objname",key = "pk ") --> in update method first pass primary key then object
	 * 			
	 * 				**** Do not use @Cachable for select all methods as cache is small memory so it is not recommended
	 * 
	 * 		***** If parent class has Has-A with any child class then do the same for child class also
	 * 
	 * 		--->  
	 * 
	 * 			
	 * 
	
	 * 
	 * 
	 * 
	 * **/
	
}
