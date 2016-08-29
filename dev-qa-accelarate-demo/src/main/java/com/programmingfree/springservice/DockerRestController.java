package com.programmingfree.springservice;


import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class DockerRestController {

    @RequestMapping(value = "/dockerize", method = RequestMethod.POST)
    public String dockerize(@RequestBody GitData data) {
        System.out.println("data " + data.getRepoName() + " - " + data.getBranch());
        buildDocker(data.getRepoName(), data.getBranch());
        return "Success";
    }

    @Async
    private void buildDocker(String repo, String branch) {
        System.out.println("Build Docker Command.............. ");
        try {
            String command = "sudo docker build --build-arg REPO=" + repo + " --build-arg BRANCH=" + branch +
                    " -t saravananshun/dev-image .";
            Process proc = Runtime.getRuntime().exec(command);

            InputStream is = proc.getInputStream();
            OutputStream os = proc.getOutputStream();

            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(is));

            BufferedWriter writer
                    = new BufferedWriter(new OutputStreamWriter(os));
            writer.write("pwd");
            writer.flush();
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.print(line + "\n");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Build Docker Command Finished ");
        runDocker(branch);
    }

    private void runDocker(String branch) {
        System.out.println("Running Docker Command.............. ");
        try {
            String command = "sudo docker run -d --name "+branch+" saravananshun/dev-image";
            Process proc = Runtime.getRuntime().exec(command);

            InputStream is = proc.getInputStream();
            OutputStream os = proc.getOutputStream();

            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(is));

            BufferedWriter writer
                    = new BufferedWriter(new OutputStreamWriter(os));
            writer.write("pwd");
            writer.flush();
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.print(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Running Docker Command Finished ");
    }

}
