Embulk::JavaPlugin.register_filter(
  "java-pass", "org.embulk.filter.JavaPassFilterPlugin",
  File.expand_path('../../../../classpath', __FILE__))
