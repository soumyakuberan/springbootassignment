package dbs.assignment.documents;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Getter
@Setter
@ToString(exclude = "id")
//@NoArgsConstructor
public class OrderTransaction {

  @Id private String id;
  private String from;
  private String to;
  private int amount;

  public OrderTransaction(){
    super();
  }
  public OrderTransaction(final String from, final String to, final int amount) {
    this.from = from;
    this.to = to;
    this.amount = amount;
  }

}
