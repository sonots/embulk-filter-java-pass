package org.embulk.filter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.embulk.config.ConfigSource;
import org.embulk.config.Task;
import org.embulk.config.TaskSource;
import org.embulk.spi.Exec;
import org.embulk.spi.FilterPlugin;
import org.embulk.spi.Page;
import org.embulk.spi.PageBuilder;
import org.embulk.spi.PageOutput;
import org.embulk.spi.PageReader;
import org.embulk.spi.Schema;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class JavaPassFilterPlugin implements FilterPlugin {
    public interface PluginTask extends Task {
    }

    @Override
    public void transaction(ConfigSource config, Schema inputSchema,
            FilterPlugin.Control control) {
        PluginTask task = config.loadConfig(PluginTask.class);

        Schema outputSchema = inputSchema;

        control.run(task.dump(), outputSchema);
    }

    @Override
    public PageOutput open(TaskSource taskSource, final Schema inputSchema,
            final Schema outputSchema, final PageOutput output) {
        // PluginTask task = taskSource.loadTask(PluginTask.class);

        return new PageOutput() {
            private PageReader reader = new PageReader(inputSchema);
            private PageBuilder builder = new PageBuilder(Exec.getBufferAllocator(), outputSchema, output);

            @Override
            public void finish() {
                output.finish();
                builder.finish();
            }

            @Override
            public void close() {
                output.close();
                builder.close();
            }

            @Override
            public void add(Page page) {
                reader.setPage(page);

                while (reader.nextRecord()) {
                    String value1 = reader.getString(0);
                    builder.setString(0, value1);
                    builder.addRecord();
                }
            }
        };
    }
}
