<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20191017184710 extends AbstractMigration
{
    public function getDescription() : string
    {
        return '';
    }

    public function up(Schema $schema) : void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->abortIf($this->connection->getDatabasePlatform()->getName() !== 'mysql', 'Migration can only be executed safely on \'mysql\'.');

        $this->addSql('CREATE TABLE provider (id INT NOT NULL, access_group_name VARCHAR(255) NOT NULL, access_group_id INT NOT NULL, total_uses INT NOT NULL, event_id INT NOT NULL, structure_decode TINYINT(1) NOT NULL, name VARCHAR(255) NOT NULL, modified DATETIME DEFAULT NULL, basic_product_id INT NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ENGINE = InnoDB');
        $this->addSql('CREATE TABLE provider_session (provider_id INT NOT NULL, session_id INT NOT NULL, INDEX IDX_201C7773A53A8AA (provider_id), INDEX IDX_201C7773613FECDF (session_id), PRIMARY KEY(provider_id, session_id)) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ENGINE = InnoDB');
        $this->addSql('CREATE TABLE session (id INT NOT NULL, name VARCHAR(255) NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ENGINE = InnoDB');
        $this->addSql('ALTER TABLE provider_session ADD CONSTRAINT FK_201C7773A53A8AA FOREIGN KEY (provider_id) REFERENCES provider (id) ON DELETE CASCADE');
        $this->addSql('ALTER TABLE provider_session ADD CONSTRAINT FK_201C7773613FECDF FOREIGN KEY (session_id) REFERENCES session (id) ON DELETE CASCADE');
    }

    public function down(Schema $schema) : void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->abortIf($this->connection->getDatabasePlatform()->getName() !== 'mysql', 'Migration can only be executed safely on \'mysql\'.');

        $this->addSql('ALTER TABLE provider_session DROP FOREIGN KEY FK_201C7773A53A8AA');
        $this->addSql('ALTER TABLE provider_session DROP FOREIGN KEY FK_201C7773613FECDF');
        $this->addSql('DROP TABLE provider');
        $this->addSql('DROP TABLE provider_session');
        $this->addSql('DROP TABLE session');
    }
}
