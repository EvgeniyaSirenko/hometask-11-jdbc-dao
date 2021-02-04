package ua.mainacademy.model;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	private Integer id;
	private String name;
	private Integer code;
	private Integer price;
	private Integer initPrice;
	private String url;
	private String imageUrl;
	private String group;
}
