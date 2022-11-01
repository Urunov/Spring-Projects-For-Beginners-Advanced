package uz.edu.springjobrunnerdevop.service;



import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.jobrunr.jobs.annotations.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class JobServiceImplementation implements JobServices{
    //
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void execute() {
        execute("System in Process");
    }

    @Override
    public void execute(String input) {
      logger.info("The sample job has begun. The variable you passed is {}", input);
      try {
          waitSomeTime();
      } finally {
          logger.info("Sample job has finished...");
      }
    }
    @SneakyThrows
    private void waitSomeTime() {
        System.out.println("Begin Processing with .");
        Thread.sleep(3000);
    }
}
