Embulk::JavaPlugin.register_filter(
  "java_pass", "org.embulk.filter.JavaPassFilterPlugin",
  File.expand_path('../../../../classpath', __FILE__))
