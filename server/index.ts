import { App } from "https://deno.land/x/attain/mod.ts";
import charactersList from "./constants/charactersList.ts";
const app = new App();

app.use("/list", (req, res) => {
  res.status(200).send(charactersList);
})

app.listen({ port: 8080 });

console.log("http://localhost:8080");