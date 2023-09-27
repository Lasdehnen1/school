-- liquibase formatted sql

-- changeset epichugov:1
CREATE INDEX names_index ON student (name);

-- changeset epichugov:2
CREATE INDEX facultyAndColor_index ON faculty (name, color);