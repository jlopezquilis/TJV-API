package cz.cvut.fit.tjv.project.tjvapi.entities;

//Purpose: For getting Id in service scope. All entities will implement this interface (adds abstraction).
public interface EntityWithId<ID> {
    ID getId();

    void setId(ID id);
}