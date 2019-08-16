/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doisoat.utils;

import doisoat.models.VNPayFooterModel;
import doisoat.models.VNPayHeaderModel;
import doisoat.models.VNPayModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;



/**
 *
 * @author lucnt
 */
public class ReadFileUtils {
    public static String getContentFile(File file) {
		StringBuilder content = new StringBuilder();
		try {
			BufferedReader br = Files.newBufferedReader(file.toPath());
			String line;
			while ((line = br.readLine()) != null) {
				content.append(line).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content.toString();
	}
	
	interface FileReaderCallback {
		void ContentHeader(VNPayHeaderModel dataHeader);
		void Content(ArrayList<VNPayModel> contents);
		void ContentFooter(VNPayFooterModel dataFooter);
	}
}
