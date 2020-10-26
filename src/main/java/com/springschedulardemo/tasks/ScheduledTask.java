package com.springschedulardemo.tasks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.springschedulardemo.entity.BuildFileInfo;

@Component
public class ScheduledTask {

	@Autowired
	private Map<String, Double> conversionId;
	
	@Value("${filePath}")
	private String filePath;

	@Scheduled(fixedRate = 5000)
	public void readFile() throws FileNotFoundException {
		String buildFilePath = filePath+"build.txt";
		String buildFile = null;
		try {
			buildFile = new String(Files.readAllBytes(Paths.get(buildFilePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * check build file contains data or not. If not present don't process
		 */
		if (buildFile != null && !buildFile.isEmpty()) {
			Gson gsonObj = new Gson();
			BuildFileInfo info = gsonObj.fromJson(buildFile, BuildFileInfo.class);

			String datFilePath = filePath + info.getFilename();
			String dataFile = null;
			try {
				dataFile = new String(Files.readAllBytes(Paths.get(datFilePath)));
			} catch (IOException e) {
				e.printStackTrace();
			}

			/**
			 * Check data file contains data or not If not present don't process
			 */
			if (dataFile != null && !dataFile.isEmpty()) {
				JsonObject jsonObj = gsonObj.fromJson(dataFile, JsonObject.class);
				Set<String> keySet = jsonObj.keySet();
				for (String key : keySet) {
					Double dataValue = Double.parseDouble(jsonObj.get(key).toString());
					if (conversionId.containsKey(key)) {
						double value = conversionId.get(key);
						if (value != dataValue) {
							conversionId.put(key, dataValue);
						}
					} else {
						conversionId.put(key, dataValue);
					}
				}
			}
		}
	}

}