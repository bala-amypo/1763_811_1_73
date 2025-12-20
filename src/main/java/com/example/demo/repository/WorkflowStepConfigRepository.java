

@PostMapping("/create")
public Entity save(@RequestBody Entity obj)

@GetMapping("/{id}")
public Entity get(@PathVariable Long id)

@GetMapping("/all")
public List<Entity> getAll()

@DeleteMapping("/{id}")
public void delete(@PathVariable Long id)
