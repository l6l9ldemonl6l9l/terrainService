package distributedsystems.terrainService.api.restControllers;

import distributedsystems.terrainService.api.payload.TerrainPayload;
import distributedsystems.terrainService.services.models.Terrain;
import distributedsystems.terrainService.services.IService.TerrainIService;
import distributedsystems.terrainService.TerrainApplication;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/terrain")
@RequiredArgsConstructor
public final class TerrainController {
    static final Logger log = LoggerFactory.getLogger(TerrainApplication.class);

    @Autowired
    private TerrainIService TerrainService;

    @GetMapping
    public ResponseEntity<List<Terrain>> index() {
        return ResponseEntity.ok(TerrainService.findAll());
    }

    @PostMapping
    public ResponseEntity<Terrain> create(@RequestBody TerrainPayload payload) {
        Terrain newTerrain = new Terrain(payload.getName(),
                payload.getSizeBeauty());
        return ResponseEntity.ok(TerrainService.save(newTerrain));
    }

    @GetMapping("{TerrainId}")
    public ResponseEntity<Terrain> show(@PathVariable UUID TerrainId) throws NotFoundException {
        return ResponseEntity.ok(TerrainService.getById(TerrainId));
    }

    @DeleteMapping("{TerrainId}")
    public ResponseEntity<Void> delete(@PathVariable UUID TerrainId) throws NotFoundException {
        TerrainService.deleteById(TerrainId);
        return ResponseEntity.noContent().build();
    }
}