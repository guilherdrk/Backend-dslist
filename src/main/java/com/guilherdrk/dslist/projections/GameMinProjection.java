package com.guilherdrk.dslist.projections;

import com.guilherdrk.dslist.model.Game;

public interface GameMinProjection {

    Long getId();
    String getTitle();
    Integer getGameYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();


}
