package com.guilherdrk.dslist.projections;

import com.guilherdrk.dslist.model.Game;

public interface GameMinProjection {

    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();


}
