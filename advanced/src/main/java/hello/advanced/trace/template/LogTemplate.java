package hello.advanced.trace.template;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LogTemplate {

    private final LogTrace trace;

    public <T> T execute(TemplateCallback<T> callback, String message) {
        TraceStatus status = null;

        try {
            status = trace.begin(message);

            T call = callback.call();

            trace.end(status);
            return call;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
