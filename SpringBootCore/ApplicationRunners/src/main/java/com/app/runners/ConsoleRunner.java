package com.app.runners;

import java.util.List;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

// the difference between CLR and AR is that AR store arguments (optional and non optional) as
//  optional - Map<String, List<String>  , non-optional - List<String>  


@Component
public class ConsoleRunner implements ApplicationRunner{
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		// all optional keys
		
		Set<String> optionKeys = args.getOptionNames();
		System.out.println(optionKeys);
		
		// all non-optional keys 
		
		List<String> nonOptionKeys = args.getNonOptionArgs();
		System.out.println(nonOptionKeys);
		
		// all arguments 
		
		String[] arg = args.getSourceArgs();
		System.out.println(arg);
		
		// check one key related value 
		List<String> list = args.getOptionValues("profile");
		System.out.println(list);
		
		//check key exist
		
		System.out.println(args.containsOption("nature"));
		System.out.println(args.containsOption("db"));
		
		
	}

}
