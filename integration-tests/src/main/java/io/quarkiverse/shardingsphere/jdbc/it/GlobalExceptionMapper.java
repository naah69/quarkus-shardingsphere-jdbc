package io.quarkiverse.shardingsphere.jdbc.it;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * GlobalExceptionMapper
 *
 * @author nayan
 * @date 2022/9/24 10:57
 */
//@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Throwable> {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionMapper.class);

    @Override
    public Response toResponse(Throwable exception) {
        log.error("error", exception);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}
