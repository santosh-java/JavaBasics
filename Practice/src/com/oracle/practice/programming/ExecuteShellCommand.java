package com.oracle.practice.programming;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class ExecuteShellCommand {

	public static void main(String[] args) {
		ExecuteShellCommand esh = new ExecuteShellCommand();
		System.out.println("Terminal output for command 'top -n 1 -b'");
		esh.runShellCommand("top", "-n", "1", "-b");
		System.out.println("Terminal output for command 'free'");
		esh.runShellCommand("free");
		System.out.println("Terminal output for command 'ifconfig'");
		esh.runShellCommand("top", "-l");
	}

	public int runShellCommand(String... command) {
		ProcessBuilder pb = new ProcessBuilder(command);
		try {
			Map<String, String> environment = pb.environment();
			String envTerm = environment.get("TERM");
			if (null != envTerm && !envTerm.isEmpty()) {
				System.out.println(envTerm);
			} else {
				environment.put("TERM", "xterm");
			}
			pb.directory(new File("/tmp"));
			pb.redirectError(new File("/tmp/processExec.err"));
			// To redirect the output of the executed command to a file, use below line of
			// code
//			pb.redirectOutput(new File("/tmp/processExec.out"));
			Process process = pb.start();

			try (InputStream inputStream = process.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));) {
				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			}
			int exitCode = process.waitFor();
			System.out.println("Exitcode of the process is: " + exitCode);
			if (exitCode != 0) {
				System.out.println(
						"There seems to be an error in the command execution. Please check /tmp/processExec.err file for details of the failure.");
			}
			return exitCode;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
}
