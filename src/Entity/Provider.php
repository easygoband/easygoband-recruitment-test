<?php

namespace App\Entity;

use DateTime;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\EntityManager;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass="App\Repository\ProviderRepository")
 */
class Provider
{
    /**
     * @ORM\Id()
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $accessGroupName;

    /**
     * @ORM\Column(type="integer")
     */
    private $accessGroupId;

    /**
     * @ORM\Column(type="integer")
     */
    private $totalUses;

    /**
     * @ORM\ManyToMany(targetEntity="App\Entity\Session", inversedBy="providers")
     */
    private $sessions;

    /**
     * @ORM\Column(type="integer")
     */
    private $eventId;

    /**
     * @ORM\Column(type="boolean")
     */
    private $structureDecode;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $name;

    /**
     * @ORM\Column(type="datetime", nullable=true)
     */
    private $modified;

    /**
     * @ORM\Column(type="integer")
     */
    private $basicProductId;

    public function __construct()
    {
        $this->sessions = new ArrayCollection();
    }

    public function create(
        int $id,
        string $accessGroupName,
        int $accessGroupId,
        int $totalUses,
        int $eventId,
        bool $structureDecode,
        string $name,
        int $basicProductId,
        DateTime $modified = null
    )
    {
        $this->id = $id;
        $this->accessGroupName = $accessGroupName;
        $this->accessGroupId = $accessGroupId;
        $this->totalUses = $totalUses;
        $this->eventId = $eventId;
        $this->structureDecode = $structureDecode;
        $this->name = $name;
        $this->basicProductId = $basicProductId;
        $this->modified = $modified;
    }

    public function update(
        string $accessGroupName,
        int $accessGroupId,
        int $totalUses,
        int $eventId,
        bool $structureDecode,
        string $name,
        int $basicProductId,
        DateTime $modified = null
    )
    {
        $this->accessGroupName = $accessGroupName;
        $this->accessGroupId = $accessGroupId;
        $this->totalUses = $totalUses;
        $this->eventId = $eventId;
        $this->structureDecode = $structureDecode;
        $this->name = $name;
        $this->basicProductId = $basicProductId;
        $this->modified = $modified;
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function setId($id): void
    {
        $this->id = $id;
    }

    public function getAccessGroupName(): ?string
    {
        return $this->accessGroupName;
    }

    public function setAccessGroupName(string $accessGroupName): self
    {
        $this->accessGroupName = $accessGroupName;

        return $this;
    }

    public function getAccessGroupId(): ?int
    {
        return $this->accessGroupId;
    }

    public function setAccessGroupId(int $accessGroupId): self
    {
        $this->accessGroupId = $accessGroupId;

        return $this;
    }

    public function getTotalUses(): ?int
    {
        return $this->totalUses;
    }

    public function setTotalUses(int $totalUses): self
    {
        $this->totalUses = $totalUses;

        return $this;
    }

    public function getEventId(): ?int
    {
        return $this->eventId;
    }

    public function setEventId(int $eventId): self
    {
        $this->eventId = $eventId;

        return $this;
    }

    public function getStructureDecode(): ?bool
    {
        return $this->structureDecode;
    }

    public function setStructureDecode(bool $structureDecode): self
    {
        $this->structureDecode = $structureDecode;

        return $this;
    }

    public function getName(): ?string
    {
        return $this->name;
    }

    public function setName(string $name): self
    {
        $this->name = $name;

        return $this;
    }

    public function getBasicProductId(): ?int
    {
        return $this->basicProductId;
    }

    public function setBasicProductId(int $basicProductId): self
    {
        $this->basicProductId = $basicProductId;

        return $this;
    }

    public function getModified(): ?\DateTimeInterface
    {
        return $this->modified;
    }

    public function setModified(?\DateTimeInterface $modified): self
    {
        $this->modified = $modified;

        return $this;
    }

    /**
     * @return Collection|Session[]
     */
    public function getSessions(): Collection
    {
        return $this->sessions;
    }

    public function addSession(Session $session): self
    {
        if (!$this->sessions->contains($session)) {
            $this->sessions[] = $session;
        }

        return $this;
    }

    public function removeSession(Session $session): self
    {
        if ($this->sessions->contains($session)) {
            $this->sessions->removeElement($session);
        }

        return $this;
    }
}
