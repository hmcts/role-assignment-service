package io.cucumber.plugin.event;

import org.apiguardian.api.API;
import org.junit.AssumptionViolatedException;

import java.time.Duration;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

@API(status = API.Status.STABLE)
public final class Result2 {

    private final Status status;
    private final Duration duration;
    private final Throwable error;

    /**
     * The result of a step or scenario
     *
     * @param status   status of the step or scenario
     * @param duration the duration
     * @param error    the error that caused the failure if any
     */
    public Result2(Status status, Duration duration, Throwable error) {
        if (error instanceof AssumptionViolatedException) {
            error = null;
            status = Status.PASSED;
        }
        this.status = requireNonNull(status);
        this.duration = requireNonNull(duration);
        this.error = error;
    }

    public Status getStatus() {
        return status;
    }

    public Duration getDuration() {
        return duration;
    }

    /**
     * Returns the error encountered while executing a step or scenario. Will
     * return null when passed. May return null when undefined in case of the
     * empty scenario or when skipped due to a failing prior step.
     *
     * @return the error encountered while executing a step or scenario.
     */
    public Throwable getError() {
        return error;
    }

    @Override
    public String toString() {
        return "Result{" +
            "status=" + status +
            ", duration=" + duration.getSeconds() +
            ", error=" + error +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result2 resultTemp = (Result2) o;
        return status == resultTemp.status &&
            Objects.equals(duration, resultTemp.duration) &&
            Objects.equals(error, resultTemp.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, duration, error);
    }
}
