package distributedsystems.terrainService.services.IService;

import distributedsystems.terrainService.services.models.Terrain;
import javassist.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface TerrainIService {
    List<Terrain> findAll();

    Terrain save(Terrain TerrainForSave);

    Terrain getById(UUID id) throws NotFoundException;

    void deleteById(UUID id) throws NotFoundException;
}
