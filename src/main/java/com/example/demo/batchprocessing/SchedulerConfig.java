@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer, DisposableBean {

	ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
	
	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private ListeExecJobRepository rep;
	
	@Autowired
	private FichierRepository frepo;
	
	@Autowired
    private TaskService service;


	    private String s;
	    
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		
		List<Task> tasks = repository.findAll();
		tasks.forEach(t -> {
	     
			ListeExecJob liste= new ListeExecJob();
			
			liste.setDate_creation(new Date());
			
			if (t.getActive()==true) {
				liste.setDate_execution(new Date());
			Runnable runnableTask = () -> executeBatFile(t.getScript(), liste);
			//liste.setFin_execution(new Date());
	
			Trigger trigger = new Trigger() {

				@Override
				public Date nextExecutionTime(TriggerContext triggerContext) {

					CronTrigger crontrigger = new CronTrigger(t.getCronExpression());

					return crontrigger.nextExecutionTime(triggerContext);
				}

			};
			
			taskRegistrar.addTriggerTask(runnableTask, trigger);
			//liste.setFin_execution(new Date());
	}
			//t.addListe(liste);
			liste.setTask(t);
			rep.save(liste);
		
		});
		
	}

	@Override
	public void destroy() throws Exception {

		if (executor != null) {

			executor.shutdownNow();

		}
	}
	
	//@Transactional(readOnly=true)
	public void executeBatFile(String filePath, ListeExecJob liste) {
	
		try {
			Runtime.getRuntime().
			   exec("cmd /c " + filePath);
			liste.setStatus("succès");
			liste.setFin_execution(new Date());
			/*String fichierlog;

                ProcessBuilder process = new ProcessBuilder(filePath);
                process.redirectErrorStream(true);

                Process shell = process.start();

                //shell.waitFor();
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(shell.getInputStream()));
                BufferedReader stdError = new BufferedReader(new InputStreamReader(shell.getErrorStream()));

                // read the output from the command
                System.out.println("Here is the standard output of the command:\n");
                while ((fichierlog = stdInput.readLine()) != null) {
                    System.out.println("s:" + fichierlog );
                }

                // read any errors from the attempted command
                System.out.println("Here is the standard error of the command (if any):\n");
                while ((fichierlog  = stdError.readLine()) != null) {
                    System.out.println("w:" + fichierlog );
                    
                }
                liste.setLogfile(fichierlog);
                liste.setStatus("succès");
    			liste.setFin_execution(new Date());*/
			
		} catch (IOException e) {
			e.printStackTrace();
			liste.setStatus("échoué");
			
		}
		rep.save(liste);
	}
	

@Bean
public ScheduledExecutorService executor(){
    return executor;
}

@Bean
public ScheduledTaskRegistrar taskRegistrar(){
	return new ScheduledTaskRegistrar();
}
}
