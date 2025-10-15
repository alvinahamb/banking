using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace DepotServiceAPI.Migrations
{
    /// <inheritdoc />
    public partial class Update : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_compteDepot_taux_IdTaux",
                table: "compteDepot");

            migrationBuilder.DropForeignKey(
                name: "FK_historiqueStatusComptes_compteDepot_IdCompteDepot",
                table: "historiqueStatusComptes");

            migrationBuilder.DropForeignKey(
                name: "FK_historiqueStatusComptes_status_IdStatus",
                table: "historiqueStatusComptes");

            migrationBuilder.DropForeignKey(
                name: "FK_operationsDepot_compteDepot_IdCompteDepot",
                table: "operationsDepot");

            migrationBuilder.DropForeignKey(
                name: "FK_operationsDepot_typeOperation_IdTypeTransaction",
                table: "operationsDepot");

            migrationBuilder.DropIndex(
                name: "IX_operationsDepot_IdCompteDepot",
                table: "operationsDepot");

            migrationBuilder.DropIndex(
                name: "IX_operationsDepot_IdTypeTransaction",
                table: "operationsDepot");

            migrationBuilder.DropIndex(
                name: "IX_historiqueStatusComptes_IdCompteDepot",
                table: "historiqueStatusComptes");

            migrationBuilder.DropIndex(
                name: "IX_historiqueStatusComptes_IdStatus",
                table: "historiqueStatusComptes");

            migrationBuilder.DropIndex(
                name: "IX_compteDepot_IdTaux",
                table: "compteDepot");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateIndex(
                name: "IX_operationsDepot_IdCompteDepot",
                table: "operationsDepot",
                column: "IdCompteDepot");

            migrationBuilder.CreateIndex(
                name: "IX_operationsDepot_IdTypeTransaction",
                table: "operationsDepot",
                column: "IdTypeTransaction");

            migrationBuilder.CreateIndex(
                name: "IX_historiqueStatusComptes_IdCompteDepot",
                table: "historiqueStatusComptes",
                column: "IdCompteDepot");

            migrationBuilder.CreateIndex(
                name: "IX_historiqueStatusComptes_IdStatus",
                table: "historiqueStatusComptes",
                column: "IdStatus");

            migrationBuilder.CreateIndex(
                name: "IX_compteDepot_IdTaux",
                table: "compteDepot",
                column: "IdTaux");

            migrationBuilder.AddForeignKey(
                name: "FK_compteDepot_taux_IdTaux",
                table: "compteDepot",
                column: "IdTaux",
                principalTable: "taux",
                principalColumn: "IdTaux",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_historiqueStatusComptes_compteDepot_IdCompteDepot",
                table: "historiqueStatusComptes",
                column: "IdCompteDepot",
                principalTable: "compteDepot",
                principalColumn: "IdCompteDepot",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_historiqueStatusComptes_status_IdStatus",
                table: "historiqueStatusComptes",
                column: "IdStatus",
                principalTable: "status",
                principalColumn: "IdStatus",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_operationsDepot_compteDepot_IdCompteDepot",
                table: "operationsDepot",
                column: "IdCompteDepot",
                principalTable: "compteDepot",
                principalColumn: "IdCompteDepot",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_operationsDepot_typeOperation_IdTypeTransaction",
                table: "operationsDepot",
                column: "IdTypeTransaction",
                principalTable: "typeOperation",
                principalColumn: "IdTypeOperation",
                onDelete: ReferentialAction.Cascade);
        }
    }
}
