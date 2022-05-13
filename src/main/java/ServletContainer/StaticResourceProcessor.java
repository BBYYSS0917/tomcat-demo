package ServletContainer;

import java.io.IOException;

public class StaticResourceProcessor {

  public void process(ex02.pyrmont.Request request, Response response) {
    try {
      response.sendStaticResource();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}