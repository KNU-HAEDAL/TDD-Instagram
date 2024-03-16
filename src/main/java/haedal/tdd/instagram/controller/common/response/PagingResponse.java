package haedal.tdd.instagram.controller.common.response;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class PagingResponse<T> {
    private boolean hasNext;
    private List<T> data;
}
