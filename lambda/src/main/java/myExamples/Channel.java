package myExamples;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class Channel {

    private int id;
    private String name;
    private ChannelType type;


}
