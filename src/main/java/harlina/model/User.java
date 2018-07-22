package harlina.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class User implements Serializable
{
    private String name;
    private String email;

    @Override
    public String toString() {
        return email + ",  ";
    }
}
