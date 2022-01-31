# to8-game-builder

to produce the JAR and all its dependencies, including Engine (asm) and tools (lwasm, exo, etc.) :

```bash
$ mvn assembly:single
```

Then the uber-jar is in `.\target\to8-game-builder-0.0.1-SNAPSHOT-jar-with-dependencies.jar`